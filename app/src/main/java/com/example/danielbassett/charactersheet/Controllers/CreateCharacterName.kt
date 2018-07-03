package com.example.danielbassett.charactersheet.Controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.danielbassett.charactersheet.Models.PlayerCharacter
import com.example.danielbassett.charactersheet.R
import kotlinx.android.synthetic.main.activity_create_character_name.*
import kotlinx.android.synthetic.main.gender_selector.*
import kotlinx.android.synthetic.main.race_selector.*

class CreateCharacterName : AppCompatActivity() {

    var charName = ""
    var charRace = ""
    var charGender = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_character_name)
    }
    fun characterSummary(name: String = charName, race: String = charRace, gender: String = charGender) {
        tv_raceInformation.text = "$charName, $charGender, $charRace"
    }

    fun updateCharacterButton(name: String = charName, race: String = charRace, gender: String = charGender) {
        if (charName != "" && charRace != "" && charGender != "") {
            val characterSummary = "Create $name, the $gender $race."
            btn_saveCharacter.text = characterSummary
        } else {
            btn_saveCharacter.text = "Save Character"

        }
    }

    fun onRaceClicked(view: View) {
        //Construct the builder
        val builder = AlertDialog.Builder(this)
        //Add the layout
        val dialogView = layoutInflater.inflate(R.layout.race_selector, null)
        //needs all methods, the positive button, the negative button.
        builder.setView(dialogView)
                .setPositiveButton("Select") { dialogInterface, i ->
                    if (rb_human.isChecked) {
                        charRace = "human"
                    }
                    if (rb_dwarf.isChecked) {
                        charRace = "dwarf"
                    }
                    if (rb_elf.isChecked) {
                        charRace = "elf"
                    }
                    if (rb_halfling.isChecked) {
                        charRace = "halfling"
                    } else {
                        charRace = ""
                    }
                }
                .setNegativeButton("Cancel") { dialogInterface, i ->
                    //Cancel and close the dialog
                }
                .show()
        updateCharacterButton()
        if (charRace != "") {
            btn_raceSelector.text = charRace
        }
    }

    fun onGenerateRandomNameClicked(view: View) {
        //should generate a popup dialog which has the core races available to select from.
        //will pull from a database of random names of that race.
        TODO()
    }

    fun onGenderClicked(view: View) {
        val builder = AlertDialog.Builder(this)
        //Add the layout
        val dialogView = layoutInflater.inflate(R.layout.gender_selector, null)
        //needs all methods, the positive button, the negative button.
        builder.setView(dialogView)
                .setPositiveButton("Select") { dialogInterface, i ->
                    if (rb_male.isChecked) {
                        charGender = "male"
                    }
                    if (rb_female.isChecked) {
                        charGender = "female"
                    }
                    if (rb_other.isChecked) {
                        charGender = "attack helicopter"
                    } else {
                        charGender = ""
                    }
                }
                .setNegativeButton("Cancel") { dialogInterface, i ->
                    //Cancel and close the dialog
                }
                .show()
        updateCharacterButton()
    }
    fun onSaveCharacterClicked(view: View) {

        if (charName != "" && charRace != "" && charGender != "") {
            val characterid: Int = 1
            //Function will later assign id automatically
            val newCharacter: PlayerCharacter = PlayerCharacter(characterid, charName, charRace, charGender)
        } else {
            Toast.makeText(this, "You are missing something...", Toast.LENGTH_SHORT).show()
        }
    }
}




