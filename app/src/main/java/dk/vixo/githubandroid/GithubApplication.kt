package dk.vixo.githubandroid

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dk.vixo.githubandroid.di.DaggerAppComponent

class GithubApplication : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(applicationContext)
    }

}