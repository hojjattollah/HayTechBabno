package com.example.hytechbabno.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.babnowidgets.button.RecordButton
import com.example.hytechbabno.R
import kotlinx.android.synthetic.main.activity_record_button.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

class RecordButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_button)
        recordButton.mode = RecordButton.Mode.Ready

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            stopLatch.set(true)
            when (checkedId) {
                idle.id -> recordButton.mode = RecordButton.Mode.Idle
                ready.id -> recordButton.mode = RecordButton.Mode.Ready
                recording.id -> recordButton.mode = RecordButton.Mode.Recording
                loading.id -> {
                    stopLatch.set(false)
                    recordButton.mode = RecordButton.Mode.Loading
                    recordButton.progress = 0
                    var step = 0
                    timer(100, TimeUnit.MILLISECONDS) {
                        recordButton.progress = ++step
                        if (step >= 100) {
                            it.set(true)
                        }
                    }
                }
            }
        }
    }

    private val handler = Handler()
    private val stopLatch = AtomicBoolean()
    private fun timer(interval: Long, timeUnit: TimeUnit, task: (AtomicBoolean) -> Unit): AtomicBoolean {
        handler.postDelayed({
            if (stopLatch.get()) {
                return@postDelayed
            }
            task.invoke(stopLatch)
            timer(interval, timeUnit, task)
        }, timeUnit.toMillis(interval))
        return stopLatch
    }
}