package FD.android.Renault.Alpine.AlpineF1.ui.car

import FD.android.Renault.Alpine.AlpineF1.databinding.FragmentCarBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class CarFragment: Fragment() {
    private var _binding: FragmentCarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val carViewModel =
            ViewModelProvider(this).get(CarViewModel::class.java)

        _binding = FragmentCarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCar
        carViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}