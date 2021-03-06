package me.cullycross.valerie.graphics.renderers

import android.content.Context
import android.opengl.GLES20.*
import android.opengl.GLSurfaceView
import android.opengl.Matrix.*
import timber.log.Timber
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: Valerie
 * Date: 11/20/15
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */
abstract class Abstract2dRenderer(protected val context: Context) : GLSurfaceView.Renderer {

    protected var aspectRatio: Float = 0f

    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f)
    }

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        glViewport(0, 0, width, height)

        // currently it's width / height
        aspectRatio = width.toFloat() / height.toFloat()

        Timber.i("Width is %d, height is %d, aspect is %f", width, height, aspectRatio)
    }

    override fun onDrawFrame(gl: GL10) {
        glClear(GL_COLOR_BUFFER_BIT)
    }
}
