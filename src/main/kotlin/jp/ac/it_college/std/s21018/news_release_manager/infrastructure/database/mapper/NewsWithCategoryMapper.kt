package jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper


import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.id
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.NewsWithCategory
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

@Mapper
interface NewsWithCategoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithCategoryResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "body", property = "body", jdbcType = JdbcType.LONGVARCHAR),
            Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.BIGINT),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "publish_at", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithCategory>


    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("NewsWithCategoryResult")
    fun selectOne(selectStatement: SelectStatementProvider): NewsWithCategory?
}



private val columnList = listOf(id, title, categoryId, createAt, publishAt,userId,body)

fun NewsWithCategoryMapper.select(): List<NewsWithCategory> =
    select(columnList) {
        from(news, "n")
        leftJoin(category) {
            on(news.id) equalTo category.id
        }
    }.run(this::selectMany)

fun NewsWithCategoryMapper.selectByPrimaryKey(id_: Long): NewsWithCategory? = select(columnList) {
    from(news, "n")
    leftJoin(category, "c") {
        on(news.id) equalTo category.id
    }
    where {
        id isEqualTo id_
    }
}.run ( this::selectOne )