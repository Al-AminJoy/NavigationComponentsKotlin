package com.alamin.navigationcomponents_kotlin

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class SpecifyAmountFragment : Fragment(),View.OnClickListener {
    lateinit var navController:NavController;
    lateinit var recipient:String;
    lateinit var input: TextInputEditText;
    lateinit var txtRecipient: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view);
        input = view.findViewById(R.id.input_amount);
        txtRecipient = view.findViewById(R.id.recipient);
        txtRecipient.text = "Seding money to $recipient"
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this);
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.send_btn ->{
                if (!TextUtils.isEmpty(input.text.toString())){
                    val bundle  = bundleOf("recipient" to recipient,"amount" to input.text.toString())
                    navController?.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle)                }
            }
            R.id.cancel_btn -> activity?.onBackPressed();
        }
    }
}