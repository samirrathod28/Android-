package com.example.easyrent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {

    lateinit var mobileLayout: TextInputLayout
    lateinit var nameLayout: TextInputLayout
    lateinit var emailLayout: TextInputLayout
    lateinit var passLayout: TextInputLayout
    lateinit var cnfLayout: TextInputLayout
    lateinit var mobileNum:EditText
    lateinit var userName:EditText
    lateinit var emailId:EditText
    lateinit var pass1:EditText
    lateinit var cnfPass:EditText
    lateinit var registerBtn:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        nameLayout = view.findViewById(R.id.textLayoutName)
        emailLayout = view.findViewById(R.id.textLayoutEmailId)
        passLayout = view.findViewById(R.id.textLayoutPassword)
        cnfLayout = view.findViewById(R.id.textLayoutCfmPass)
        mobileLayout=view.findViewById(R.id.textLayoutMobileNum)
        mobileNum = view.findViewById(R.id.mobileNum)
        userName=view.findViewById(R.id.user_name)
        emailId=view.findViewById(R.id.Email)
        pass1=view.findViewById(R.id.Password)
        cnfPass=view.findViewById(R.id.cnf_Password)
        registerBtn=view.findViewById(R.id.registerBtn)

        registerBtn.setOnClickListener(){

            var name = userName.text.toString()
            var email = emailId.text.toString()
            var pass = pass1.text.toString()
            var cnfPass = cnfPass.text.toString()
            var mobile = mobileNum.text.toString()




            if(name.isEmpty()){
                nameLayout.isHelperTextEnabled = true
                nameLayout.error ="Enter Name"

            }else if (email.isEmpty()){

                emailLayout.isHelperTextEnabled = true
                emailLayout.error ="Enter Email"

            }else if (mobile.isEmpty()){

               mobileLayout.isHelperTextEnabled = true
                mobileLayout.error ="Enter Mobile No."

            }else if (mobile.length !=10){

                mobileLayout.isHelperTextEnabled = true
                mobileLayout.error= "Only 10 digit Number Only"
            }

            else if (pass.isEmpty()){

                passLayout.isHelperTextEnabled = true
                passLayout.error ="Enter Password"

            }else if(cnfPass.isEmpty()) {

                cnfLayout.isHelperTextEnabled = true
                cnfLayout.error = "Enter Confirm Password"

            }else if (cnfPass != pass){

                cnfLayout.isHelperTextEnabled = true
                cnfLayout.error = "Didn't Match Password"
            }
            else{
                var stringRequest: StringRequest =object: StringRequest(Request.Method.POST,"https://unapprised-countrie.000webhostapp.com/EasyRent/insert.php",
                    Response.Listener
                    {
                        Toast.makeText(context,"Registration Success",Toast.LENGTH_LONG).show()
                    },
                    {
                        Toast.makeText(context,"No Internet",Toast.LENGTH_LONG).show()
                    })

                {
                    override fun getParams(): MutableMap<String, String>
                    {
                        val map = HashMap<String, String>()
                        map["name"]=name
                        map["email"]=email
                        map["mobileno"]=mobile
                        map["password"]=pass

                        return map
                    }

                }
                val queue = Volley.newRequestQueue(context)
                queue.add(stringRequest)

            }
        }

        return view
    }

}