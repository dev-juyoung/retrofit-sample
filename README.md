Android Retrofit Sample
==================

해당 Repository는 Android에서 REST API 통신을 위한 `Retrofit` Library 사용에 대한 Sample을 작성한 Repository 입니다.
[Retrofit 공식페이지][retrofit]에도 언급된 `Github API`의 `Repository 검색 API`를 이용하여 `android`라는 키워드를 이용하여 `star`가 높은 순으로 sorting되도록 예제를 작성하였습니다.

References
----------
> `Retrofit` 사용에 대한 조금 더 자세한 방법을 원하시면 아래의 링크를 참고하세요!
* [FutureStudio][futurestudio-blog]
  * Retrofit 이 외의 Glide, Picasso, Gson 등 여러 종류의 Library를 다루는 방법에 대한 자료도 있습니다!
* [dev-juyoung 블로그][blog]
  * 제가 관리하는 블로그입니다. ~~저도 초보라 특별한 내용은 없어요...ㅠㅠ~~

Branches
--------
* master
  * 최종 결과물에 대한 병합.
* basic-usage
  * [Retrofit 공식페이지][retrofit]에서 기본적으로 제공하고 있는 사용법을 다룹니다.
* service-generator
  * ServiceGenerator Class를 이용하여, API 통신 시 선언되어야 될 Retrofit 보일러플레이트 코드에 대한 중복을 제거하는 방법을 다룹니다.
* mvc
  * Android 개발 시, 사용되는 일반적인 MVC Pattern을 이용하여, `Retrofit`과 통신결과를 `RecyclerView`에 표출하는 방법을 다룹니다.
* mvp
  * `mvc` branch에서 작성된 코드를 이용하여 MVP Pattern을 적용한 코드의 예시 입니다.

 [futurestudio-blog]: https://futurestud.io/tutorials/retrofit-getting-started-and-android-client
 [blog]: http://thdev.tech/androiddev/2016/10/12/Android-MVP-Intro.html
 [retrofit]: http://square.github.io/retrofit/