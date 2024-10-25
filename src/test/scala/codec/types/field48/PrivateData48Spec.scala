package codec.types.field48

import codec.ISO8583Definition.PRIVATE_DATA
import codec.types.field48.types.*
import org.scalatest.OptionValues
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import scodec.bits.HexStringSyntax

class PrivateData48Spec extends AnyFlatSpec with OptionValues {

  "Private data (48)" should "be decoded" in {
    val infoSize = hex"00db"
    val type01   = hex"010200"
    val type02   = hex"02040250"
    val type03   = hex"030201"
    val type04   = hex"040202"
    val type05   = hex"050200"
    val type06   = hex"060211"
    val type07   = hex"070203"
    val type08   = hex"080C000000001234"
    val type09   = hex"09041234"
    val type10   = hex"100204"
    val type11   = hex"110200"
    val type12   = hex"120200"
    val type13   = hex"130227"
    val type14   = hex"14040216"
    val type15   = hex"1506030104"
    val type16   = hex"160C000000002000"
    val type17   = hex"170C000000002000"
    val type18   = hex"180200"
    val type19   = hex"190201"
    val type20   = hex"200C000000002001"
    val type21   = hex"210C000000002002"
    val type22   = hex"220209"
    val type23   = hex"230212"
    val type24   = hex"240202"
    val type25   = hex"2505F14BA74BA7"
    val type26   = hex"262466333865363934382D353338382D343161362D626361342D623439373233633139343337"
    val type27   = hex"2709C4F0F0F0F0F2F5F0F0"
    val type28   = hex"280c000000002500"
    val type29   = hex"290c000000001500"
    val type30   = hex"300c000000000500"
    val type31   = hex"31041234"
    val type32   = hex"320FF0F1F2F3F4F5F6F7F8F9F1F0F1F1F1"
    val type33   = hex"3303F2F6F7"
    val type34   = hex"3409F0F1F2F3F4F5F6F7F8"

    val tokenDataHex =
      (infoSize ++ type01 ++ type02 ++ type03 ++ type04 ++ type05 ++
        type06 ++ type07 ++ type08 ++ type09 ++ type10 ++ type11 ++
        type12 ++ type13 ++ type14 ++ type15 ++ type16 ++ type17 ++
        type18 ++ type19 ++ type20 ++ type21 ++ type22 ++ type23 ++
        type24 ++ type25 ++ type26 ++ type27 ++ type28 ++ type29 ++
        type30 ++ type31 ++ type32 ++ type33 ++ type34).bits

    println(tokenDataHex.size / 8)
    val result = PRIVATE_DATA.decode(tokenDataHex).toOption.value.value

    result.operationType01.value.code mustBe OperationType4801.OperationType.CREDIT
    result.acceptanceCountryCode02.value.code.getAlpha3 mustBe "FRA"
    result.transactionEnvType03.value.`type` mustBe TransactionEnvType4803.EnvType.PROXIMITY_EVENT
    result.trackOrChip04.value.`type` mustBe TrackOrChip4804.EnvType.CHIP_READING
    result.originTransactionReturnCode05.value.value mustBe "00"
    result.terminalPartialAuthorSupport06.value.`type` mustBe TerminalPartialAuthorSupport4806.TerminalSupport.SUPPORT_ALL
    result.originTransactionNetwork07.value.network mustBe OriginTransactionNetwork4807.Network.BANCONTACT
    result.cashbackAmount08.value.value mustBe "000000001234"
    result.accountingPeriodNb09.value.value mustBe "1234"
    result.paymentOption10.value.option mustBe PaymentOption4810.PaymentOption.THREE_TIMES_PAYMENT
    result.transactionStatus11.value.status mustBe TransactionStatus4811.Status.NORMAL
    result.preAuthorizationValidityPeriod12.value.value mustBe "00"
    result.deviceType13.value.device mustBe DeviceType4813.Device.TAG
    result.walletType14.value.`type` mustBe WalletType4814.WalletType.GOOGLE_PAY
    result.transactionAnalysis15.value.status mustBe TransactionAnalysis4815.Status.DI
    result.transactionAnalysis15.value.reason mustBe List(TransactionAnalysis4815.Reason.CAM, TransactionAnalysis4815.Reason.CVF)
    result.offlineAccumulator1_16.value.amount mustBe "000000002000"
    result.offlineAccumulator2_17.value.amount mustBe "000000002000"
    result.resetAccumulator1_18.value.toReset mustBe true
    result.resetAccumulator2_19.value.toReset mustBe false
    result.offlineContactLimitAmount20.value.amount mustBe "000000002001"
    result.offlineContactlessLimitAmount21.value.amount mustBe "000000002002"
    result.transactionCategoryCode22.value.categoryCode mustBe TransactionCategoryCode4822.TransactionCategoryCode.UNIQUE
    result.schemeNetworkAuthentication23.value.`type` mustBe SchemeNetworkAuthentication4823.AuthenticationType.FORMAT_ERROR
    result.eCommerceAuthentificationFlag24.value.flag mustBe ECommerceAuthentificationFlag4824.AuthentificationFlag.ATTEMPT
    result.protocolVersion25.value.version mustBe "1.x.x"
    result.DS_ACS_TransactionId26.value.id mustBe "f38e6948-5388-41a6-bca4-b49723c19437"
    result.amountTransactionFee27.value.side mustBe "D"
    result.amountTransactionFee27.value.amount mustBe "00002500"
    result.atmServiceFee28.value.amount mustBe "000000002500"
    result.atmDisloyaltyFee29.value.amount mustBe "000000001500"
    result.creditCardFee30.value.amount mustBe "000000000500"
    result.localMerchantCategoryCode31.value.categoryCode mustBe "1234"
    result.merchantId32.value.id mustBe "012345678910111"
    result.financialNetworkCode33.value.code mustBe "267"
    result.banknetReferenceNumber34.value.number mustBe "012345678"

    val encodeResult = PRIVATE_DATA.encode(result).toOption.value
    encodeResult.toHex mustBe tokenDataHex.toHex
  }

}
