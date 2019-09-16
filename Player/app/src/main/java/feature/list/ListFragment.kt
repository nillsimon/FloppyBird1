package feature.list


import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.simon.player.R
import kotlinx.android.synthetic.main.fragment_list.*
import okhttp3.internal.EMPTY_REQUEST
import java.util.jar.Manifest

const val REQUEST_CODE = 1
class ListFragment : Fragment() {
    companion object{
        private const val TYPE_NAME = "type_name"

        fun newInstance(typeName: String):ListFragment{
            var bundle = Bundle().apply {
                putString(TYPE_NAME, typeName)
            }
            return ListFragment().apply { arguments = bundle }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        subscribe()
    }
    private fun initView(){
        rvMedia.layoutManager = LinearLayoutManager(context)
        btnStartStop.setOnClickListener{}

    }
    private fun subscribe(){

    }
    private fun checkPermission() = ContextCompat.checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE)
    private fun requestPermission(){
        ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            when(requestCode){
                REQUEST_CODE ->{
                if(grantResults.isEmpty()&& grantResults[0] == PackageManager.PERMISSION_GRANTED){
                }
            }
        }
    }
}
