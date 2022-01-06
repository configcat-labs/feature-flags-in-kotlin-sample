package sample.apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val infoFragment = AccountFragment()
    private val accountFragment = CartFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragment(homeFragment)

        bottom_bar?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.dashboard_home -> switchFragment(homeFragment)
                R.id.dashboard_account -> switchFragment(infoFragment)
                R.id.dashboard_cart -> switchFragment(accountFragment)
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun switchFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, fragment)
            transaction.commit()
        }
    }
}