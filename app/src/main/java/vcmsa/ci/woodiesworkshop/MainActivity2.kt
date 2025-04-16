package vcmsa.ci.woodiesworkshop

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var tvDisplay:TextView
    private lateinit var radioGroup:RadioGroup
    private lateinit var radioDoor:RadioButton
    private lateinit var radioShelf:RadioButton
    private lateinit var radioTable: RadioButton
    private lateinit var radioFurniture:RadioButton
    private lateinit var checkBoxNails:CheckBox
    private lateinit var checkboxHinges: CheckBox
    private lateinit var checkBoxWood: CheckBox
    private lateinit var checkBoxWoodGlue: CheckBox
    private lateinit var etHours:EditText
    private lateinit var btnCalculate:Button
    private lateinit var tvDisplayResult: TextView
    private lateinit var btnClear:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //initialize all views
        tvDisplay= findViewById(R.id.tvDisplay)
        radioGroup= findViewById(R.id.radioGroup)
        radioTable= findViewById(R.id.radioTable)
        radioDoor= findViewById(R.id.radioDoor)
        radioShelf= findViewById(R.id.radioShelf)
        radioFurniture= findViewById(R.id.radioFurniture)
        checkBoxNails= findViewById(R.id.checkboxNails)
        checkboxHinges= findViewById(R.id.checkboxHinges)
        checkBoxWoodGlue= findViewById(R.id.checkboxWoodGlue)
        checkBoxWood= findViewById(R.id.checkboxWood)
        etHours= findViewById(R.id.etHours)
        btnCalculate= findViewById(R.id.btnCalculate)
        tvDisplayResult= findViewById(R.id.tvDisplayResult)
        btnClear= findViewById(R.id.btnClear)

        //calculate button logic
        btnCalculate.setOnClickListener{
            val  selectedRadioButtonId=
                radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId==-1){
                Toast.makeText(this,"please select a task",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val selectedTask= when
                    (selectedRadioButtonId){
                        R.id.radioDoor->"Door"
                        R.id.radioFurniture->"Furniture"
                        R.id.radioTable->"Table"
                        R.id.radioShelf->"Shelf"
                else-> "Unknown"
                    }
            var total = 0
            if (checkBoxNails.isChecked)
                total+=10
            if (checkboxHinges.isChecked)
                total+=20
            if (checkBoxWoodGlue.isChecked)
                total+=50
            if (checkBoxWood.isChecked)
                total+=600

            tvDisplayResult.text= "task:$selectedTask\nTotal:R$total"
        }
        //clear button logic
        btnClear.setOnClickListener {
            radioGroup.clearCheck()
            checkBoxNails.isChecked=false
            checkboxHinges.isChecked=false
            checkBoxWoodGlue.isChecked=false
            checkBoxWood.isChecked=false
            tvDisplayResult.text=""
        }
    }

}