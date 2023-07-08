package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.ui.list.TaskViewModel
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var edtTitle: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val factory = ViewModelFactory.getInstance(this)
        val taskViewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)

        val taskId = intent.getIntExtra(TASK_ID, -1)
        if (taskId != -1) {
            val taskLiveData = taskViewModel.task

            taskViewModel.setTaskId(taskId)
            taskLiveData.observe(this) { task ->
                edtTitle = findViewById(R.id.detail_ed_title)
                if (task != null) {
                    setDetailData(task)
                } else {
                    setDetailError()
                }
            }

            val deleteButton = findViewById<Button>(R.id.btn_delete_task)
            deleteButton.setOnClickListener {
                taskViewModel.deleteTask()
                finish()
            }
        } else {
            finish()
        }
    }

    private fun setDetailData(task: Task) {
        val edtDescription = findViewById<TextInputEditText>(R.id.detail_ed_description)
        val edtDueDate = findViewById<TextInputEditText>(R.id.detail_ed_due_date)
        edtTitle.setText(task.title)
        edtDescription.setText(task.description)
        edtDueDate.setText(DateConverter.convertMillisToString(task.dueDateMillis))
    }

    private fun setDetailError() {
        edtTitle.setText(R.string.detail_error_message)
    }
}