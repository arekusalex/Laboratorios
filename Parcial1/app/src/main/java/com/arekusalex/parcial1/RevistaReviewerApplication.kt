package com.arekusalex.parcial1

import android.app.Application
import com.arekusalex.parcial1.repositories.RevistaRepository
import com.arekusalex.parcial1.data.revistas

class RevistaReviewerApplication: Application() {
    val revistaRepository: RevistaRepository by lazy{
        RevistaRepository(revistas)
    }
}