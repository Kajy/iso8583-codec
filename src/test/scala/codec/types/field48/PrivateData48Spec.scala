package codec.types.field48

import codec.ISO8583Definition.PRIVATE_DATA
import codec.types.field48.types.*
import codec.types.field48.types.RecurringPaymentIndicator4835.RecurringPaymentIndicator
import codec.types.field48.types.TransitTransactionTypeIdentifier4837.TransitTransactionTypeIdentifier
import codec.types.field48.types.TransportationModeIndicator4838.TransportationModeIndicator
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.*

class PrivateData48Spec extends AnyFlatSpec with OptionValues {

  "Private data (48)" should "be decoded" in {
    val infoSize = hex"011a".bits
    val type01   = hex"010200".bits
    val type02   = hex"02040250".bits
    val type03   = hex"030201".bits
    val type04   = hex"040202".bits
    val type05   = hex"050200".bits
    val type06   = hex"060211".bits
    val type07   = hex"070203".bits
    val type08   = hex"080C000000001234".bits
    val type09   = hex"09041234".bits
    val type10   = hex"100204".bits
    val type11   = hex"110200".bits
    val type12   = hex"120200".bits
    val type13   = hex"130227".bits
    val type14   = hex"14040216".bits
    val type15   = hex"1506030104".bits
    val type16   = hex"160C000000002000".bits
    val type17   = hex"170C000000002000".bits
    val type18   = hex"180200".bits
    val type19   = hex"190201".bits
    val type20   = hex"200C000000002001".bits
    val type21   = hex"210C000000002002".bits
    val type22   = hex"220209".bits
    val type23   = hex"230212".bits
    val type24   = hex"240202".bits
    val type25   = hex"2505F14BA74BA7".bits
    val type26   = hex"262486f3f885f6f9f4f860f5f3f8f860f4f181f660828381f46082f4f9f7f2f383f1f9f4f3f7".bits
    val type27   = hex"2709C4F0F0F0F0F2F5F0F0".bits
    val type28   = hex"280c000000002500".bits
    val type29   = hex"290c000000001500".bits
    val type30   = hex"300c000000000500".bits
    val type31   = hex"31041234".bits
    val type32   = hex"320FF0F1F2F3F4F5F6F7F8F9F1F0F1F1F1".bits
    val type33   = hex"3303F2F6F7".bits
    val type34   = hex"3409F0F1F2F3F4F5F6F7F8".bits
    val type35   = hex"350203".bits
    val type36   = hex"3606011411".bits
    val type37   = hex"370203".bits
    val type38   = hex"380211".bits
    val type39   = hex"390869972522".bits
    val type40   = hex"4001C4".bits
    val type41   = hex"4106012345".bits
    val type42   = hex"4205F3F4F4F1F0".bits
    val type43   = hex"43080106123456020211".bits
    val type44   = hex"4404E589A281".bits
    val type45   = hex"4505F1F2F3F4F5".bits
    val type46   = BitVector.fromValidHex("46011")
    val type47   = BitVector.fromValidHex("47011")

    val tokenDataHex =
      infoSize ++ type01 ++ type02 ++ type03 ++ type04 ++ type05 ++
        type06 ++ type07 ++ type08 ++ type09 ++ type10 ++ type11 ++
        type12 ++ type13 ++ type14 ++ type15 ++ type16 ++ type17 ++
        type18 ++ type19 ++ type20 ++ type21 ++ type22 ++ type23 ++
        type24 ++ type25 ++ type26 ++ type27 ++ type28 ++ type29 ++
        type30 ++ type31 ++ type32 ++ type33 ++ type34 ++ type35 ++
        type36 ++ type37 ++ type38 ++ type39 ++ type40 ++ type41 ++
        type42 ++ type43 ++ type44 ++ type45 ++ type46 ++ type47

    println(tokenDataHex.size / 8)
    val result = PRIVATE_DATA.decode(tokenDataHex).toOption.value.value

    result.operationType01.value.code mustBe OperationType4801.OperationType.CREDIT
    result.acceptanceCountryCode02.value.code.getAlpha3 mustBe "FRA"
    result.transactionEnvType03.value.`type` mustBe TransactionEnvType4803.EnvType.PROXIMITY_EVENT
    result.trackOrChip04.value.`type` mustBe TrackOrChip4804.EnvType.CHIP_READING
    result.originTransactionReturnCode05.value.value mustBe "00"
    result.terminalPartialAuthorSupport06.value.`type` mustBe TerminalPartialAuthorSupport4806.TerminalSupport.SUPPORT_ALL
    result.originTransactionNetwork07.value.network mustBe OriginTransactionNetwork4807.Network.BANCONTACT
    result.cashbackAmount08.value.amount mustBe 1234
    result.accountingPeriodNb09.value.periodNb mustBe 1234
    result.paymentOption10.value.option mustBe PaymentOption4810.PaymentOption.THREE_TIMES_PAYMENT
    result.transactionStatus11.value.status mustBe TransactionStatus4811.Status.NORMAL
    result.preAuthorizationValidityPeriod12.value.value mustBe "00"
    result.deviceType13.value.device mustBe DeviceType4813.Device.TAG
    result.walletType14.value.`type` mustBe WalletType4814.WalletType.GOOGLE_PAY
    result.transactionAnalysis15.value.status mustBe TransactionAnalysis4815.Status.DI
    result.transactionAnalysis15.value.reason mustBe List(TransactionAnalysis4815.Reason.CAM, TransactionAnalysis4815.Reason.CVF)
    result.offlineAccumulator1_16.value.amount mustBe 2000
    result.offlineAccumulator2_17.value.amount mustBe 2000
    result.resetAccumulator1_18.value.toReset mustBe true
    result.resetAccumulator2_19.value.toReset mustBe false
    result.offlineContactLimitAmount20.value.amount mustBe 2001
    result.offlineContactlessLimitAmount21.value.amount mustBe 2002
    result.transactionCategoryCode22.value.categoryCode mustBe TransactionCategoryCode4822.TransactionCategoryCode.UNIQUE
    result.schemeNetworkAuthentication23.value.`type` mustBe SchemeNetworkAuthentication4823.AuthenticationType.FORMAT_ERROR
    result.eCommerceAuthentificationFlag24.value.flag mustBe ECommerceAuthentificationFlag4824.AuthentificationFlag.ATTEMPT
    result.protocolVersion25.value.version mustBe "1.x.x"
    result.DS_ACS_TransactionId26.value.id mustBe "f38e6948-5388-41a6-bca4-b49723c19437"
    result.amountTransactionFee27.value.side mustBe "D"
    result.amountTransactionFee27.value.amount mustBe "00002500"
    result.atmServiceFee28.value.amount mustBe 2500
    result.atmDisloyaltyFee29.value.amount mustBe 1500
    result.creditCardFee30.value.amount mustBe 500
    result.localMerchantCategoryCode31.value.categoryCode mustBe 1234
    result.merchantId32.value.id mustBe "012345678910111"
    result.financialNetworkCode33.value.code mustBe "267"
    result.banknetReferenceNumber34.value.number mustBe "012345678"
    result.recurringPaymentIndicator35.value.`type` mustBe RecurringPaymentIndicator.SUBSEQUENT_RECURRING
    result.finalAuthorizationIndicator36.value.value mustBe "011411"
    result.transitTransactionTypeIdentifier37.value.`type` mustBe TransitTransactionTypeIdentifier.POST_AUTHORIZED_AGG
    result.transportationModeIndicator38.value.mode mustBe TransportationModeIndicator.RURAL_BUS
    result.referenceConversionRate39.value.rate mustBe 9.972522
    result.referenceConversionRateSide40.value.side mustBe "D"
    result.referenceConversionRatePercentDiff41.value.rate mustBe 123.45
    result.POSPostalCode42.value.code mustBe "34410"
    // Test of subtypes in AdditionalFraudData4843Spec
    result.additionalFraudData43.nonEmpty mustBe true
    result.exchangeRateProvider44.value.provider mustBe "Visa"
    result.rateTableId45.value.id mustBe "12345"
    result.persistentFxEligibleIndicator46.value.isEligible mustBe true
    result.persistentFxAppliedIndicator47.value.isApplied mustBe true

    val encodeResult = PRIVATE_DATA.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}
