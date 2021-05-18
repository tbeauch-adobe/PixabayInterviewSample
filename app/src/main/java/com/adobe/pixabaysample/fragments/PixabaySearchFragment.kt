package com.adobe.pixabaysample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.adobe.pixabaysample.R
import com.adobe.pixabaysample.adapters.ListVideosAdapter
import com.adobe.pixabaysample.databinding.FragmentPixabaySearchBinding
import com.adobe.pixabaysample.viewmodels.BrowseVideosViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * UI to search the Pixabay video API
 */
@AndroidEntryPoint
class PixabaySearchFragment : Fragment() {

    private lateinit var viewBinding: FragmentPixabaySearchBinding

    private val adapter: ListVideosAdapter by lazy { ListVideosAdapter() }
    private val browseVideosViewModel: BrowseVideosViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentPixabaySearchBinding.inflate(inflater, container, false)

        viewBinding.imagesListRecyclerview.layoutManager = GridLayoutManager(viewBinding.root.context, resources.getInteger(R.integer.browse_column_count))
        viewBinding.imagesListRecyclerview.adapter = adapter

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        browseVideosViewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            viewState?.videoPreviews?.let {
                adapter.submitList(it)
            }

            viewState?.searchTerm?.let {
                viewBinding.searchTermEdittext.setText(it)
            }
        }
    }
}