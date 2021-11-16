package com.alamin.navigationcomponents_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class ConfirmationFragment : Fragment() {


    lateinit var message : TextView;

    val args : ConfirmationFragmentArgs by navArgs();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val money = args.money;
        message = view.findViewById(R.id.confirmation_message);

        message.text = "${money.amount} Tk Send By ${money.name} "
    }

}