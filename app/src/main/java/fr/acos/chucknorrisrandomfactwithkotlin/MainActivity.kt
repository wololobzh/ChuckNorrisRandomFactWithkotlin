package fr.acos.chucknorrisrandomfactwithkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.acos.chucknorrisrandomfactwithkotlin.dao.FactDao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickButtonRandom(view: View)
    {
        Thread({
            //Consommation du web service
            val fact  = FactDao.getFact()
            //Quand le web service renvoi une réponse : mise à jour de l'ihm
            runOnUiThread({
                tv_fact.text = fact.fact
            })
        }).start()
    }
}
