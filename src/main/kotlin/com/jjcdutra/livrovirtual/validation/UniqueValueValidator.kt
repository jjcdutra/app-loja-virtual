package com.jjcdutra.livrovirtual.validation

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.Query
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.util.Assert
import kotlin.reflect.KClass

class UniqueValueValidator(
    @PersistenceContext
    private val manager: EntityManager
) : ConstraintValidator<UniqueValue, Any> {

    private lateinit var domainAttribute: String
    private lateinit var klass: KClass<*>

    override fun initialize(params: UniqueValue) {
        domainAttribute = params.fieldName
        klass = params.domainClass
    }

    override fun isValid(value: Any, context: ConstraintValidatorContext): Boolean {
        val query: Query = manager.createQuery("select 1 from ${klass.simpleName} where $domainAttribute=:value")
        query.setParameter("value", value)
        val list: List<*> = query.resultList
        Assert.state(list.size <= 1, "Foi encontrado mais de um $klass com o atributo $domainAttribute")

        return list.isEmpty()
    }
}
