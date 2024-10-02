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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags._

class FiManagementSpec extends BaseSpec {

  Feature("Add Fi Journey") {

    Scenario("Add Fi Journey (Standard FI)", FiManagementTests, ZapTests) {
      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()
      When("The user hits the landing page and continues standard journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickAddFILink()
      FiNamePage.enterFiName()
      FiHaveUtrPage.fiHhaveUtrYes()
      FiUtrPage.enterFiUtr()
      FiHaveGiinPage.fiHaveGiinYes()
      FiGiinPage.enterGiin()
      FiWhereIsFiBased.basedUKYes()
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
    }

    Scenario("Add Fi Journey where Fi is user", FiManagementTests, ZapTests) {
      Given("The user logs in as Auto Matched user")
      AuthLoginPage.loginAsAutoMatchedUser()
      When("The user hits the landing page and continues standard journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickAddFILink()
      FiReportForRegisteredBusinessPage.fiAddYourBusiness()
      FiIsThisYourBusinessNamePage.fiConfirmBusinessName()
      FiHaveGiinPage.fiHaveGiinYes()
      FiGiinPage.enterGiin()
      FiIsTheAddressCorrectPage.fiConfirmRegisteredBusinessAddress()
      Then("The user completes journey and lands on check your answer page")
      FiRegisteredBusinessCheckYourAnswersPage.confirmAndSend()
      FiFinancialInstitutionAddedPage.checkPage()
    }
  }
}
