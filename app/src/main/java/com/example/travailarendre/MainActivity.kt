package com.example.travailarendre

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var nom : EditText
    lateinit var date : EditText
    lateinit var email : EditText
    lateinit var classe : EditText
    lateinit var btn : Button
    lateinit var layout : LinearLayout
    lateinit var txt : TextView
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nom = findViewById(R.id.nom)

        email = findViewById(R.id.email)
     //   classe = findViewById(R.id.classe)
        btn = findViewById(R.id.submit)
        layout = findViewById(R.id.layout)
        txt = findViewById(R.id.txt)
        spinner = findViewById(R.id.idclasse)
        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)
        //val textView     = findViewById<TextView>(R.id.dateTv)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        var msg = String()

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                //textView.setText("" + dayOfMonth + " " + month + ", " + year)
                msg = "" + dayOfMonth + " " + month + ", " + year

            }, year, month, day)
            dpd.show()

        }

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.classe,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        btn.setOnClickListener{
            if (nom.text.length==0)
                /*Snackbar.make(
                    layout,
                    "Veuillez entrer un nom et prénom",
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(
                        "OK", View.OnClickListener {  }
                    ).show()*/
                nom.setError("Veuillez entrer un nom et prénom")

            else {
                if (msg.length==0)
                    Snackbar.make(
                        layout,
                        "Veuillez entrer une date de naissance",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction(
                            "OK", View.OnClickListener {  }
                        ).show()
                    //msg.setError.("Veuillez entrer une date de naissance")


                else {
                    if (email.text.length==0)
                       /* Snackbar.make(
                            layout,
                            "Veuillez entrer un email",
                            Snackbar.LENGTH_INDEFINITE)
                            .setAction(
                                "OK", View.OnClickListener {  }
                            ).show()*/
                        email.setError("Veuillez entrer un email")


                    else {
                        if (spinner.selectedItem ==null)
                            Snackbar.make(
                                layout,
                                "Veuillez entrer une classe",
                                Snackbar.LENGTH_INDEFINITE)
                                .setAction(
                                    "OK", View.OnClickListener {  }
                                ).show()
                            //spinner.setError("Veuillez entrer une classe")

                        else {
                            val intent = Intent(this, MainActivity2::class.java)
                            // start your next activity

                            intent.putExtra("nom",nom.text.toString())
                            intent.putExtra("date",msg)
                            intent.putExtra("email",email.text.toString())
                            intent.putExtra("classe",spinner.selectedItem.toString())
                            startActivity(intent)
                        }
                    }


                }

            }



        }

    }
}