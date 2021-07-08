package com.example.githubrepo.utils

interface Mapper<S, T> {
    fun map(source: S): T
}