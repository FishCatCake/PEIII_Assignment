package com.example.pe_assignment.article

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.*
import com.example.pe_assignment.login.LoginFragmentDirections
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_login.*


class ArticleHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var hot = view.findViewById<ImageButton>(R.id.hot1)
        hot.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://lifecoachingandtherapy.com/2020/06/08/7-solo-sex-tips-for-all-adults-on-national-sex-day/")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        hot = view.findViewById(R.id.hot2)
        hot.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://www.realsimple.com/beauty-fashion/clothing/shopping-guide")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        hot = view.findViewById(R.id.hot3)
        hot.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://www.shopify.com/enterprise/ecommerce-fashion-industry")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        var recent = view.findViewById<ImageButton>(R.id.recent1)
        recent.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://www.buzzfeed.com/terripous/pieces-of-advice-all-women-need-to-hear")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        recent = view.findViewById(R.id.recent2)
        recent.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://abcflora.com/blogs/flower-blog/best-flowers-to-give-a-girl")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        recent = view.findViewById(R.id.recent3)
        recent.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://iamafoodblog.com/")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        var handpick = view.findViewById<ImageButton>(R.id.handpick1)
        handpick.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://www.nytimes.com/guides/well/beginner-yoga")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        handpick = view.findViewById<ImageButton>(R.id.handpick2)
        handpick.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://osteopathic.org/what-is-osteopathic-medicine/benefits-of-yoga/")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        handpick = view.findViewById<ImageButton>(R.id.handpick3)
        handpick.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url","https://www.vogue.in/beauty/gallery/the-biggest-hair-colour-trends-for-2022")
            view.findNavController().navigate(R.id.articleFragment,bundle)
        }

        val btnSend = view.findViewById<ImageButton>(R.id.back_btn)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }

    }

}
