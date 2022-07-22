package com.example.e_greetings.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.e_greetings.R
import com.example.e_greetings.other.MyUrl
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener()
        {
            var fname=edtFirstName.text.toString()
            var lname=edtLastName.text.toString()
            var email=edtEmail.text.toString()
            var phone=edtPhone.text.toString()
            var pass=edtPassword.text.toString()
            var cpass=edtConfirmPassword.text.toString()

            if(pass == cpass)
            {
                var stringRequest: StringRequest =object :StringRequest(Request.Method.POST, MyUrl.register,
                    Response.Listener {

                    Toast.makeText(applicationContext,"Registration Successful",Toast.LENGTH_LONG).show()
                    var i =Intent(this,VerifyActivity::class.java)
                        i.putExtra("number",phone)
                        startActivity(i)
                }
                    ,
                    {

                        Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

                    })

                {
                    override fun getParams(): MutableMap<String, String>
                    {
                        var hashmap=HashMap<String,String>()
                        hashmap.put("firstname",fname)
                        hashmap.put("lastname",lname)
                        hashmap.put("email",email)
                        hashmap.put("phone",phone)
                        hashmap.put("password",pass)
                        return hashmap
                    }
                }

                var queue: RequestQueue = Volley.newRequestQueue(this)
                queue.add(stringRequest)

            }

            else
            {
                Toast.makeText(applicationContext,"password and confirm password are not same",Toast.LENGTH_LONG).show()
            }
        }
        btnAlreadyAccount.setOnClickListener(){

            startActivity(Intent(this,LoginActivity::class.java))

        }
    }
}