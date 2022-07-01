package jp.ac.it_college.std.s21018.news_release_manager.domain.model

data class NewsWIthCategoryModel(
    val news: NewsModel,
    val category: CategoryModel?
) {
    val isCategory: Boolean
        get() = category !=null
}
