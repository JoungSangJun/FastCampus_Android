package com.example.fastcampus

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class _18SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreferences 사용법
        findViewById<TextView>(R.id.create).setOnClickListener {
            //create
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            // MODE
            // MODE_PRIVATE -> 현재 앱에서만 사용을 하겠다 -> 다른 앱과 공유하지 않겠다
            // MODE_WORLD_READABLE -> 다른 앱에서도 사용가능(읽기만 가능)
            // MODE_WORLD_WRITABLE -> 다른 앱에서도 사용가능(읽기 쓰기 가능)
            // MODE_MULTI_PROCESS -> 이미 호출되어 사용중인지 체크
            // MODE_APPEND -> 기존 preferences 에 신규로 추가
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key", "hello")
            editor.commit() //작업의 단위의 마지막
        }
        findViewById<TextView>(R.id.read).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val valueOne = sharedPreferences.getString("key", "empty")
            Log.d("testt", valueOne!!)
        }

        findViewById<TextView>(R.id.update).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key", "hello hello") //덮어쓰기
            editor.commit()
        }

        findViewById<TextView>(R.id.delete).setOnClickListener {
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear() //모든 데이터 삭제
            editor.commit()
        }
    }
}