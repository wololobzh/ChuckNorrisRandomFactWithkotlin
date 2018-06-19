package fr.acos.chucknorrisrandomfactwithkotlin.dao

import android.util.Log
import fr.acos.chucknorrisrandomfactwithkotlin.bo.Fact
import org.json.JSONObject
import java.net.URL

/**
 * Classe permettant d'accèder à l'api fournissant les Fact
 */
class FactDao {

    companion object {
        /**
         * Fonction qui accède à l'API
         */
        fun getFact(): Fact {
            var result: String
            result = URL("https://api.chucknorris.io/jokes/random").readText()
            return parseJSonToFact(result)
        }

        /**
         * Fonction qui parse le json en objet Fact.
         */
        private fun parseJSonToFact(json:String):Fact
        {
            val jObject = JSONObject(json)
            val id = jObject.get("id").toString()
            val fact = jObject.get("value").toString()
            val result =  Fact(id,fact)
            Log.i("XXX",result.toString())
            return result
        }
    }
}