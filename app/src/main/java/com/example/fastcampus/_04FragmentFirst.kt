package com.example.fastcampus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class _04FragmentFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : XML을 화면에 사용할 준비를 한다 (XML -> View로 만들어 준다)
        // container : 프라그먼트에서 사용될 XML의 부모뷰
        val view = inflater.inflate(R.layout.activity_04_first_fragment, container, false)
        // attachToRoot : 루트뷰에 붙일지 말지가 아님 언제 붙느냐의 차이임. true이면 바로 붙음

        (view.findViewById<TextView>(R.id.call_activity)).setOnClickListener {
            (activity as _04FragmentActivity).printTestLog()
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: String? = arguments?.getString("key")
        Log.d("testt", "data is " + data)
    }

    fun printTestLog() {
        Log.d("testt", "print test log from fragment")
    }
}