# Login Sample


Libraries Used
--------------
* [Architecture][10] - A collection of libraries that help you design robust, testable, and maintainable apps.
  * [Lifecycles][11] - Create a UI that automatically responds to lifecycle events.
  * [Navigation][12] - Handle everything needed for in-app navigation.
  * [ViewModel][13] - Easily schedule asynchronous tasks for optimal execution.
  * [Coroutines][34] - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
  * [Flow][14] - Works very well with coroutines, provides us with cold streams which can be transformed using well known reactive operators.
  * [Room][15] - Access your app's SQLite database with in-app objects and compile-time checks.
* [UI][20] - Details on why and how to use UI Components in your apps - together or separate
  * [Jetpack Compose][21] - A basic unit of composable UI.
* Third party and miscellaneous libraries
  * [Retrofit][30] for turns your HTTP API into a Java interface
  * [Gson][31] for convert Java Objects into their JSON representation
  * [Hilt][32] for [dependency injection][33]
  * [Lottie][35] for Animations.

Architecture
--------------
The app uses [MVVM architecture][10] to have a unidirectional flow of data, separation of concern, testability, and a lot more.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

App Video
--------------
https://user-images.githubusercontent.com/78587220/167302959-fbfb7665-0831-42f1-98c3-9a020e4cf2e7.mp4

LICENSE
--------------
MIT License

Copyright (c) 2022 CUMA HAZNEDAR

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

[1]: https://www.balldontlie.io/#introduction
[10]: https://developer.android.com/jetpack/compose/architecture
[11]: https://developer.android.com/jetpack/compose/lifecycle
[12]: https://developer.android.com/jetpack/compose/navigation
[13]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[14]: https://kotlinlang.org/docs/flow.html
[15]: https://developer.android.com/training/data-storage/room
[20]: https://developer.android.com/jetpack/compose/tutorial
[21]: https://developer.android.com/jetpack/compose
[30]: https://square.github.io/retrofit/
[31]: https://github.com/google/gson
[32]: https://developer.android.com/training/dependency-injection/hilt-android
[33]: https://developer.android.com/training/dependency-injection
[34]: https://developer.android.com/kotlin/coroutines
[35]: https://github.com/airbnb/lottie-android
