package com.example.pe_assignment.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.hpv.ImageAdapter
import com.example.pe_assignment.hpv.ImageModel
import com.example.pe_assignment.R
import com.example.pe_assignment.home.HomeActivityArgs
import kotlinx.android.synthetic.main.fragment_article.*


class ArticleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.webViewClient = WebViewClient()

        // this will load the url of the website
        val bundle = arguments
        val url = bundle?.getString("url")
        if (url != null) {
            Log.i("nameFra",url)
            webView.loadUrl(url)
        }


//        // this will enable the javascript settings, it can also allow xss vulnerabilities
//        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)

        val btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.articleHomeFragment)
        }


    }

}