package com.hossam.dogify

import kotlinx.coroutines.CoroutineScope

expect fun <T> runTest(block: suspend CoroutineScope.() -> T): T