package com.alamin.navigationcomponents_kotlin

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText

class ChooseRecipientFragment : Fragment(),View.OnClickListener {
    lateinit var navController : NavController;
    lateinit var input:TextInputEditText;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view);

        input = view.findViewById(R.id.input_recipient)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this);
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this);

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(input.text.toString())){
                    val bundle  = bundleOf("recipient" to input.text.toString())
                    navController?.navigate(R.id.action_chooseRecipientFragment2_to_specifyAmountFragment,bundle)
                }
            }
            R.id.cancel_btn -> activity?.onBackPressed();
        }
    }

}