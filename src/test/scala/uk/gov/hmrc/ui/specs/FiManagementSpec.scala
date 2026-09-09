/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.pages.changeRegisteredBusinessPages.*
import uk.gov.hmrc.ui.specs.tags.*

class FiManagementSpec extends BaseSpec {

  Feature("Add Fi Journey") {

    Scenario("Add Fi Journey (Standard FI) with Identifier Details", FiManagementTests, ZapTests) {
      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()
      When("The user hits the landing page and continues standard journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickAddFinancialInstitution()
      FiNamePage.enterFiName()
      FIHaveIdentificationNumbersPage.selectRadio(true)
      FiIdentificationNumbers.selectUTRandCRNYes()
      FiUtrPage.enterFiUtr()
      FiCrnPage.enterFiCrn()
      FiHaveGiinPage.fiHaveGiinYes()
      FiGiinPage.enterGiin()
      FiUKPostcode.clickOnManualAddressLink()
      FiAddressUK.enterAddressManually()
      FiContactNamePage.enterFiContactName()
      FiEmailPage.enterFiEmailAddress()
      FiHavePhonePage.fiHavePhoneYes()
      FiPhonePage.enterFiPhone()
      FiHaveSecondContactPage.fiHaveSecondContactYes()
      FiSecondContactNamePage.enterFiSecondContactName()
      FiSecondContactEmailPage.enterFiSecondContactEmailAddress()
      FiSecondContactHavePhonePage.fiSecondContactHavePhoneYes()
      FiSecondContactPhonePage.enterFiSecondContactPhone()
      Then("The user completes journey and lands on check your answer page")
      FiCheckYourAnswersPage.confirmAndSend()
      FiFinancialInstitutionAddedPage.checkPage()
      When("The user selects Back to manage your financial institutions")
      FiFinancialInstitutionAddedPage.clickBackToManageFinancialInstitutions()
      Then("The user is on the your FIs page")
      FiYourFisPage.checkPage()
    }
    Scenario("Add Fi Journey (Standard FI) without Identifier Details", FiManagementTests, ZapTests) {
      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()
      When("The user hits the landing page and continues standard journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickAddFinancialInstitution()
      FiNamePage.enterFiName()
      FIHaveIdentificationNumbersPage.selectRadio(false)
      FiHaveGiinPage.fiHaveGiinYes()
      FiGiinPage.enterGiin()
      FiUKPostcode.clickOnManualAddressLink()
      FiAddressUK.enterAddressManually()
      FiContactNamePage.enterFiContactName()
      FiEmailPage.enterFiEmailAddress()
      FiHavePhonePage.fiHavePhoneYes()
      FiPhonePage.enterFiPhone()
      FiHaveSecondContactPage.fiHaveSecondContactYes()
      FiSecondContactNamePage.enterFiSecondContactName()
      FiSecondContactEmailPage.enterFiSecondContactEmailAddress()
      FiSecondContactHavePhonePage.fiSecondContactHavePhoneYes()
      FiSecondContactPhonePage.enterFiSecondContactPhone()
      Then("The user completes journey and lands on check your answer page")
      FiCheckYourAnswersPage.confirmAndSend()
      FiFinancialInstitutionAddedPage.checkPage()
      When("The user selects Back to manage your financial institutions")
      FiFinancialInstitutionAddedPage.clickBackToManageReports()
      Then("The user is on the your FIs page")
      FiManagementFEDefaultPage.checkPage()
    }

    Scenario("Add Fi Journey where Fi is user", FiManagementTests, ZapTests) {
      Given("The user logs in as Auto Matched user")
      AuthLoginPage.loginAsOrganisationUser()
      When("The user hits the landing page and continues standard journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickAddFinancialInstitution()
      FiReportForRegisteredBusinessPage.fiAddYourBusiness()
      FiIsThisYourBusinessNamePage.fiConfirmBusinessName()
      FiHaveGiinPage.fiHaveGiinYes()
      FiGiinPage.enterGiin()
      FiIsTheAddressCorrectPage.fiConfirmRegisteredBusinessAddress()
      Then("The user completes journey and lands on check your answer page")
      FiRegisteredBusinessCheckYourAnswersPage.confirmAndSend()
      FiFinancialInstitutionAddedPage.checkPage()
      When("The user selects Back to manage your financial institutions")
      FiFinancialInstitutionAddedPage.clickBackToManageFinancialInstitutions()
      Then("The user is on the your FIs page")
      FiYourFisPage.checkPage()

    }

    Scenario("Change Registered Business Status to No", FiManagementTests, ZapTests) {
      Given("The user logs in as Organisation CT user")
      AuthLoginPage.loginAsAutoMatchedUser()
      When("The user hits the landing page and continues the  journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickManageYourFinancialInstitutions()
      FiYourFisPage.checkAndUpdateRegisteredBusinessStatus()
      And("The user click on to Change link to change the registered business to standard FI journey ")
      FiRegisteredBusinessChangeAnswersPage.changeFiRegisteredBusiness()
      FiChangeReportRegisteredBusinessPage.changeReportRegisteredBusiness()
      FiNamePage.enterFiName()
      FIHaveIdentificationNumbersPage.selectRadio(true)
      FiIdentificationNumbers.clickContinue()
      FiUtrPage.enterFiUtr()
      FiHaveGiinPage.fiHaveGiinYes()
      FiGiinPage.enterGiin()
      FiUKPostcode.clickOnManualAddressLink()
      FiAddressUK.enterAddressManually()
      FiContactNamePage.enterFiContactName()
      FiEmailPage.enterFiEmailAddress()
      FiHavePhonePage.fiHavePhoneYes()
      FiPhonePage.enterFiPhone()
      FiHaveSecondContactPage.fiHaveSecondContactYes()
      FiSecondContactNamePage.enterFiSecondContactName()
      FiSecondContactEmailPage.enterFiSecondContactEmailAddress()
      FiSecondContactHavePhonePage.fiSecondContactHavePhoneYes()
      FiSecondContactPhonePage.enterFiSecondContactPhone()
      Then("The user completes journey and lands on check your answer page")
      FiChangeAnswersPage.confirmAndSend()
      DetailsUpdatedPage.checkPage()
      When("The user selects Back to manage your CRS and FATCA Reports")
      DetailsUpdatedPage.clickBackToManageReports()
      Then("The user is on the your FIs page")
      FiManagementFEDefaultPage.checkPage()
    }

    Scenario("Landing page links to upload file page", FiManagementTests, ZapTests) {
      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()
      When("The user hits the landing page and selects upload an XML file")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickUploadFile()
      Then("The user is on the upload file page")
      UploadFilePage.checkPage()
      When("The user selects the back link")
      UploadFilePage.clickBackLink()
      Then("The user is back on the landing page")
      FiManagementFEDefaultPage.checkPage()
    }

    Scenario("Landing page links to view results of recent submissions page", FiManagementTests, ZapTests) {
      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()
      When("The user hits the landing page and selects view results of checks for recent submissions")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickViewResultsOfRecentSubmissions()
      Then("The user is on the view results page")
      ResultsOfSubmissionChecksPage.checkPage()
      When("The user selects the back link")
      ResultsOfSubmissionChecksPage.clickBackLink()
      Then("The user is back on the landing page")
      FiManagementFEDefaultPage.checkPage()
    }

    Scenario("Your FIs page links to manage reports page", FiManagementTests, ZapTests) {
      Given("The user logs in as an Organisation")
      AuthLoginPage.loginAsAutoMatchedUser()
      When("The user hits the landing page and navigates to your FIs")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickManageYourFinancialInstitutions()
      FiYourFisPage.checkPage()
      When("The user selects the link to view/manage reports for an FI")
      FiYourFisPage.clickManageReportsFor()
      Then("The user is on the manage reports page")
      ManageReportsPage.checkPage()
      When("The user selects the back link")
      ManageReportsPage.clickBackLink()
      Then("The user is back on the your FIs page")
      FiYourFisPage.checkPage()
    }

  }
}
