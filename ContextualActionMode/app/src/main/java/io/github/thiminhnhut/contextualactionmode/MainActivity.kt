package io.github.thiminhnhut.contextualactionmode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.widget.TextView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var mActionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text_view = findViewById<TextView>(R.id.text_view)
        text_view.setOnLongClickListener {
            if (mActionMode != null) {
                false
            }
            mActionMode = startSupportActionMode(mActionModeCallback)!!
            true
        }
    }

    private val mActionModeCallback = object : ActionMode.Callback {
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.option_1 -> {
                    Toast.makeText(application, "Option 1 selected", Toast.LENGTH_SHORT).show()
                    mode.finish()
                    true
                }
                R.id.option_2 -> {
                    Toast.makeText(application, "Option 2 selected", Toast.LENGTH_SHORT).show()
                    mode.finish()
                    true
                }
                else -> {
                    false
                }
            }
        }

        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.menuInflater.inflate(R.menu.example_menu, menu)
            mode.title = "Choose your option"
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            mActionMode = null
        }
    }

}
