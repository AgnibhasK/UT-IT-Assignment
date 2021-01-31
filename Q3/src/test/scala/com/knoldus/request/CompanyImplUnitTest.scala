package com.knoldus.request
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplUnitTest extends AnyFlatSpec {
  val mockedCompanyValidator = mock[CompanyValidator]
  val aCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "Company" should "be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(aCompany)) thenReturn(true)
    val result = companyImpl.createCompany(aCompany)
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(aCompany)) thenReturn(false)
    val result = companyImpl.createCompany(aCompany)
    assert(result.isEmpty)
  }
}
