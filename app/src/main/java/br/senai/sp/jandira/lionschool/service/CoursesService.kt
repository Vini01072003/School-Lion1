package br.senai.sp.jandira.lionschool.service


import br.senai.sp.jandira.lionschool.model.CoursesList
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface CoursesService {
    @GET("cursos")
    fun getCourses(): retrofit2.Call<CoursesList>
}