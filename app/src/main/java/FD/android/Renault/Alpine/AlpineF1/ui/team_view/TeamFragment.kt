package FD.android.Renault.Alpine.AlpineF1.ui.team_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import FD.android.Renault.Alpine.AlpineF1.databinding.FragmentTeamViewBinding

class TeamFragment : Fragment() {

    private var _binding: FragmentTeamViewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val teamViewModel =
                ViewModelProvider(this).get(TeamViewModel::class.java)

        _binding = FragmentTeamViewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        teamViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}