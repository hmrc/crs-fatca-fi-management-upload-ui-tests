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
import uk.gov.hmrc.test.ui.pages.changeContactDetailsPages._
import uk.gov.hmrc.test.ui.specs.tags._

class FiChangeContactDetailsSpec extends BaseSpec {

  Feature("Change contact details Journey") {

    Scenario("Change contact details (Individual)", FiManagementTests, ZapTests) {
      Given("The user logs in as an individual")
      AuthLoginPage.loginAsBasic()
      When("The user hits the landing page and continues change contact details journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickChangeContactLink()
      FiChangeContactIndividualDetailsPage.checkPage()
      FiChangeContactIndividualDetailsPage.checkPageHeader("Change your contact details")
      FiChangeContactIndividualDetailsPage.clickOnEmailChangeLink()
      FiChangeEmailPage.changeFiEmailAddress()
      FiChangeHavePhonePage.fiChangeHavePhoneNo()
      FiChangeContactIndividualDetailsPage.checkPageHeader(h1 = "Check your contact details")
      FiChangeContactIndividualDetailsPage.confirmAndSend()
      FiChangeContactDetailsUpdatedPage.checkPage()
      FiChangeContactDetailsUpdatedPage.checkPageHeader("Contact details updated")
    }

    Scenario("Change contact details (Organisation)", FiManagementTests, ZapTests) {
      Given("The user logs in as an Organisation")
      AuthLoginPage.loginAsAutoMatchedUser()
      When("The user hits the landing page and continues change contact details journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickChangeContactLinkForOrganisation()
      FiChangeContactOrganisationDetailsPage.checkPage()
      FiChangeContactOrganisationDetailsPage.checkPageHeader("Change your contact details for your organisation")
      FiChangeContactOrganisationDetailsPage.clickOnFirstContactNameChangeLink()
      FiChangeContactNameOrganisationPage.changeFiContactName()
      FiChangeEmailOrganisationPage.changeFiEmailAddress()
      FiChangeHavePhoneOrganisationPage.fiChangeHavePhoneNo()
      FiChangeContactOrganisationDetailsPage.clickOnHaveSecondContactNameChangeLink()
      FiChangeHaveSecondContactPage.fiHaveSecondContactNo()
      FiChangeContactOrganisationDetailsPage.checkPageHeader(h1 = "Check your contact details for your organisation")
      FiChangeContactOrganisationDetailsPage.confirmAndSend()
      FiChangeContactDetailsUpdatedPage.checkPage()
      FiChangeContactDetailsUpdatedPage.checkPageHeader("Contact details updated")
    }
  }
}
