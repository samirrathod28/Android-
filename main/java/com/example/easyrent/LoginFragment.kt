package com.example.easyrent


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var btn: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var textLayout:TextInputLayout
    lateinit var passLayout:TextInputLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        email =view.findViewById(R.id.email_login)
        pass = view.findViewById(R.id.Password)
        btn = view.findViewById(R.id.login_btn)
        textLayout=view.findViewById(R.id.textLayoutEmail)
        passLayout=view.findViewById(R.id.textLayoutPass)

        sharedPreferences= requireActivity().getSharedPreferences("session",Context.MODE_PRIVATE)
        if(sharedPreferences.getBoolean("session",false)&& !sharedPreferences.getString("n1","")!!.isEmpty()){

            val i = Intent(activity,Home::class.java)
            startActivity(i)
        }

        btn.setOnClickListener(){

            var mail = email.text.toString()
            var pas = pass.text.toString()

            var editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("n1",mail)
            editor.putString("p1",pas)
            sharedPreferences.edit().putBoolean("session",true).commit()
            editor.apply()
            editor.commit()

            if(mail.isEmpty() && pas.isEmpty())
            {
                textLayout.isHelperTextEnabled = true
                textLayout.error="Enter Email"
                passLayout.isHelperTextEnabled = true
                passLayout.error="Enter Password"
            }

            if(mail.isEmpty())
            {
                passLayout.error=null
                textLayout.isHelperTextEnabled = true
                textLayout.error="Enter Email"

            }

            else if(pas.isEmpty()) {
                textLayout.error = null
                passLayout.isHelperTextEnabled = true
                passLayout.error = "Enter Password"

            } else{
                val stringRequest = StringRequest(
                    Request.Method.POST,
                    "https://unapprised-countrie.000webhostapp.com/EasyRent/login.php?email=" + mail + "&password=" + pas,
                    { response ->
                        if (response.trim { it <= ' ' } == "0")
                        {
                            Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(activity,Home::class.java))
                        }
                    }) { Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show() }

                val queue = Volley.newRequestQueue(context)
                queue.add(stringRequest)

            }
        }


        return view
    }


}