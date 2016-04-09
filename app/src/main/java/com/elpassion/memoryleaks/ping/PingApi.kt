package com.elpassion.memoryleaks.ping

import rx.Observable

interface PingApi {
    fun call(): Observable<Unit>
}
