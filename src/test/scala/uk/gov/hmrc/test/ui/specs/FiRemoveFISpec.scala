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

class FiRemoveFISpec extends BaseSpec {

  Feature("Remove FI Journey") {

    Scenario("Remove FI (Organisation)", FiManagementTests, ZapTests) {
      Given("The user logs in as an Organisation")
      AuthLoginPage.loginAsAutoMatchedUser()
      When("The user hits the landing page and continues remove Fi journey")
      FiManagementFEDefaultPage.checkPage()
      FiManagementFEDefaultPage.clickManageYourFinancialInstitutions()
      FiYourFisPage.checkPage()
      FiYourFisPage.clickOnRemoveFirstFI()
      FiRemoveUserAccessFirstFiPage.willAnyoneNeedsToAccessReportsYes()
      FiRemoveOtherAccessFirstFiPage.couldAnyoneActsOnBehalfOfFirstFIYes()
      FiRemoveFirstFiPage.areYouSureToRemoveFirstFIYes()
      Then("The user should see the 'FI removed' message")
      FiRemoveSuccessFirstFiPage.checkSuccessBannerDisplayed()
    }
  }
}
