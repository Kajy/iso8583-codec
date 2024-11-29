package codec.types.field48

import codec.FieldCodecs.{LLLVAR, N}
import codec.types.field48.types.*
import scodec.Codec
import scodec.codecs.*

trait PrivateData48XX

case class PrivateData48(
    operationType01: Option[OperationType4801],
    acceptanceCountryCode02: Option[AcceptanceCountryCode4802],
    transactionEnvType03: Option[TransactionEnvType4803],
    trackOrChip04: Option[TrackOrChip4804],
    originTransactionReturnCode05: Option[OriginTransactionReturnCode4805],
    terminalPartialAuthorSupport06: Option[TerminalPartialAuthorSupport4806],
    originTransactionNetwork07: Option[OriginTransactionNetwork4807],
    cashbackAmount08: Option[CashbackAmount4808],
    accountingPeriodNb09: Option[AccountingPeriodNb4809],
    paymentOption10: Option[PaymentOption4810],
    transactionStatus11: Option[TransactionStatus4811],
    preAuthorizationValidityPeriod12: Option[PreAuthorizationValidityPeriod4812],
    deviceType13: Option[DeviceType4813],
    walletType14: Option[WalletType4814],
    transactionAnalysis15: Option[TransactionAnalysis4815],
    offlineAccumulator1_16: Option[OfflineAccumulator1_4816],
    offlineAccumulator2_17: Option[OfflineAccumulator2_4817],
    resetAccumulator1_18: Option[ResetAccumulator1_4818],
    resetAccumulator2_19: Option[ResetAccumulator2_4819],
    offlineContactLimitAmount20: Option[OfflineContactLimitAmount4820],
    offlineContactlessLimitAmount21: Option[OfflineContactlessLimitAmount4821],
    transactionCategoryCode22: Option[TransactionCategoryCode4822],
    schemeNetworkAuthentication23: Option[SchemeNetworkAuthentication4823],
    eCommerceAuthentificationFlag24: Option[ECommerceAuthentificationFlag4824],
    protocolVersion25: Option[ProtocolVersion4825],
    DS_ACS_TransactionId26: Option[DS_ACS_TransactionId4826],
    amountTransactionFee27: Option[AmountTransactionFee4827],
    atmServiceFee28: Option[ATMServiceFee4828],
    atmDisloyaltyFee29: Option[ATMDisloyaltyFee4829],
    creditCardFee30: Option[CreditCardFee4830],
    localMerchantCategoryCode31: Option[LocalMerchantCategoryCode4831],
    merchantId32: Option[MerchantId4832],
    financialNetworkCode33: Option[FinancialNetworkCode4833],
    banknetReferenceNumber34: Option[BanknetReferenceNumber4834],
    recurringPaymentIndicator35: Option[RecurringPaymentIndicator4835],
    finalAuthorizationIndicator36: Option[FinalAuthorizationIndicator4836],
    transitTransactionTypeIdentifier37: Option[TransitTransactionTypeIdentifier4837],
    transportationModeIndicator38: Option[TransportationModeIndicator4838],
    referenceConversionRate39: Option[ReferenceConversionRate4839],
    referenceConversionRateSide40: Option[ReferenceConversionRateSide4840],
    referenceConversionRatePercentDiff41: Option[ReferenceConversionRatePercentDiff4841],
    POSPostalCode42: Option[POSPostalCode4842],
    additionalFraudData43: Option[AdditionalFraudData4843],
    exchangeRateProvider44: Option[ExchangeRateProvider4844],
    rateTableId45: Option[RateTableId4845],
    persistentFxEligibleIndicator46: Option[PersistentFxEligibleIndicator4846],
    persistentFxAppliedIndicator47: Option[PersistentFxAppliedIndicator4847],
    fraudScoringData48: Option[FraudScoringData4848],
    securityServicesAdditionalData49: Option[SecurityServicesAdditionalData4849],
    merchantAdviceCode50: Option[MerchantAdviceCode4850],
    uniqueTransactionIdentifier52: Option[UniqueTransactionIdentifier4852],
    transactionLinkIdentifier53: Option[TransactionLinkIdentifier4853],
    matchKey54: Option[MatchKey4854],
    eCommerceAuthentificationType55: Option[ECommerceAuthentificationType4855]
)

object PrivateData48 {

  private val subFieldCodec =
    discriminated[PrivateData48XX]
      .by(N(2))
      .typecase("01", "OperationType01" | OperationType4801.codec)
      .typecase("02", "AcceptanceCountryCode02" | AcceptanceCountryCode4802.codec)
      .typecase("03", "TransactionEnvType03" | TransactionEnvType4803.codec)
      .typecase("04", "TrackOrChip04" | TrackOrChip4804.codec)
      .typecase("05", "OriginTransactionReturnCode05" | OriginTransactionReturnCode4805.codec)
      .typecase("06", "TerminalPartialAuthorSupport06" | TerminalPartialAuthorSupport4806.codec)
      .typecase("07", "OriginTransactionNetwork07" | OriginTransactionNetwork4807.codec)
      .typecase("08", "CashbackAmount08" | CashbackAmount4808.codec)
      .typecase("09", "AccountingPeriodNb09" | AccountingPeriodNb4809.codec)
      .typecase("10", "PaymentOption10" | PaymentOption4810.codec)
      .typecase("11", "TransactionStatus11" | TransactionStatus4811.codec)
      .typecase("12", "PreAuthorizationValidityPeriod12" | PreAuthorizationValidityPeriod4812.codec)
      .typecase("13", "DeviceType13" | DeviceType4813.codec)
      .typecase("14", "WalletType14" | WalletType4814.codec)
      .typecase("15", "TransactionAnalysis15" | TransactionAnalysis4815.codec)
      .typecase("16", "OfflineAccumulator1_16" | OfflineAccumulator1_4816.codec)
      .typecase("17", "OfflineAccumulator2_17" | OfflineAccumulator2_4817.codec)
      .typecase("18", "ResetAccumulator1_18" | ResetAccumulator1_4818.codec)
      .typecase("19", "ResetAccumulator2_19" | ResetAccumulator2_4819.codec)
      .typecase("20", "OfflineContactLimitAmount20" | OfflineContactLimitAmount4820.codec)
      .typecase("21", "OfflineContactlessLimitAmount21" | OfflineContactlessLimitAmount4821.codec)
      .typecase("22", "TransactionCategoryCode22" | TransactionCategoryCode4822.codec)
      .typecase("23", "SchemeNetworkAuthentication23" | SchemeNetworkAuthentication4823.codec)
      .typecase("24", "ECommerceAuthentificationFlag24" | ECommerceAuthentificationFlag4824.codec)
      .typecase("25", "ProtocolVersion25" | ProtocolVersion4825.codec)
      .typecase("26", "DS_ACS_TransactionId26" | DS_ACS_TransactionId4826.codec)
      .typecase("27", "AmountTransactionFee27" | AmountTransactionFee4827.codec)
      .typecase("28", "ATMServiceFee28" | ATMServiceFee4828.codec)
      .typecase("29", "ATMDisloyaltyFee29" | ATMDisloyaltyFee4829.codec)
      .typecase("30", "CreditCardFee30" | CreditCardFee4830.codec)
      .typecase("31", "LocalMerchantCategoryCode31" | LocalMerchantCategoryCode4831.codec)
      .typecase("32", "MerchantId32" | MerchantId4832.codec)
      .typecase("33", "FinancialNetworkCode33" | FinancialNetworkCode4833.codec)
      .typecase("34", "BanknetReferenceNumber34" | BanknetReferenceNumber4834.codec)
      .typecase("35", "RecurringPaymentIndicator35" | RecurringPaymentIndicator4835.codec)
      .typecase("36", "FinalAuthorizationIndicator36" | FinalAuthorizationIndicator4836.codec)
      .typecase("37", "TransitTransactionTypeIdentifier37" | TransitTransactionTypeIdentifier4837.codec)
      .typecase("38", "TransportationModeIndicator38" | TransportationModeIndicator4838.codec)
      .typecase("39", "ReferenceConversionRate39" | ReferenceConversionRate4839.codec)
      .typecase("40", "ReferenceConversionRateSide40" | ReferenceConversionRateSide4840.codec)
      .typecase("41", "ReferenceConversionRatePercentDiff41" | ReferenceConversionRatePercentDiff4841.codec)
      .typecase("42", "POSPostalCode42" | POSPostalCode4842.codec)
      .typecase("43", "AdditionalFraudData43" | AdditionalFraudData4843.codec)
      .typecase("44", "ExchangeRateProvider44" | ExchangeRateProvider4844.codec)
      .typecase("45", "RateTableId45" | RateTableId4845.codec)
      .typecase("46", "PersistentFxEligibleIndicator46" | PersistentFxEligibleIndicator4846.codec)
      .typecase("47", "PersistentFxAppliedIndicator47" | PersistentFxAppliedIndicator4847.codec)
      .typecase("48", "FraudScoringData48" | FraudScoringData4848.codec)
      .typecase("49", "SecurityServicesAdditionalData49" | SecurityServicesAdditionalData4849.codec)
      .typecase("50", "MerchantAdviceCode50" | MerchantAdviceCode4850.codec)
      .typecase("52", "UniqueTransactionIdentifier52" | UniqueTransactionIdentifier4852.codec)
      .typecase("53", "TransactionLinkIdentifier53" | TransactionLinkIdentifier4853.codec)
      .typecase("54", "MatchKey54" | MatchKey4854.codec)
      .typecase("55", "ECommerceAuthentificationType55" | ECommerceAuthentificationType4855.codec)

  val codec: Codec[PrivateData48] = LLLVAR(list(subFieldCodec).xmap(
    fields =>
      PrivateData48(
        fields.collectFirst { case t: OperationType4801 => t },
        fields.collectFirst { case t: AcceptanceCountryCode4802 => t },
        fields.collectFirst { case t: TransactionEnvType4803 => t },
        fields.collectFirst { case t: TrackOrChip4804 => t },
        fields.collectFirst { case t: OriginTransactionReturnCode4805 => t },
        fields.collectFirst { case t: TerminalPartialAuthorSupport4806 => t },
        fields.collectFirst { case t: OriginTransactionNetwork4807 => t },
        fields.collectFirst { case t: CashbackAmount4808 => t },
        fields.collectFirst { case t: AccountingPeriodNb4809 => t },
        fields.collectFirst { case t: PaymentOption4810 => t },
        fields.collectFirst { case t: TransactionStatus4811 => t },
        fields.collectFirst { case t: PreAuthorizationValidityPeriod4812 => t },
        fields.collectFirst { case t: DeviceType4813 => t },
        fields.collectFirst { case t: WalletType4814 => t },
        fields.collectFirst { case t: TransactionAnalysis4815 => t },
        fields.collectFirst { case t: OfflineAccumulator1_4816 => t },
        fields.collectFirst { case t: OfflineAccumulator2_4817 => t },
        fields.collectFirst { case t: ResetAccumulator1_4818 => t },
        fields.collectFirst { case t: ResetAccumulator2_4819 => t },
        fields.collectFirst { case t: OfflineContactLimitAmount4820 => t },
        fields.collectFirst { case t: OfflineContactlessLimitAmount4821 => t },
        fields.collectFirst { case t: TransactionCategoryCode4822 => t },
        fields.collectFirst { case t: SchemeNetworkAuthentication4823 => t },
        fields.collectFirst { case t: ECommerceAuthentificationFlag4824 => t },
        fields.collectFirst { case t: ProtocolVersion4825 => t },
        fields.collectFirst { case t: DS_ACS_TransactionId4826 => t },
        fields.collectFirst { case t: AmountTransactionFee4827 => t },
        fields.collectFirst { case t: ATMServiceFee4828 => t },
        fields.collectFirst { case t: ATMDisloyaltyFee4829 => t },
        fields.collectFirst { case t: CreditCardFee4830 => t },
        fields.collectFirst { case t: LocalMerchantCategoryCode4831 => t },
        fields.collectFirst { case t: MerchantId4832 => t },
        fields.collectFirst { case t: FinancialNetworkCode4833 => t },
        fields.collectFirst { case t: BanknetReferenceNumber4834 => t },
        fields.collectFirst { case t: RecurringPaymentIndicator4835 => t },
        fields.collectFirst { case t: FinalAuthorizationIndicator4836 => t },
        fields.collectFirst { case t: TransitTransactionTypeIdentifier4837 => t },
        fields.collectFirst { case t: TransportationModeIndicator4838 => t },
        fields.collectFirst { case t: ReferenceConversionRate4839 => t },
        fields.collectFirst { case t: ReferenceConversionRateSide4840 => t },
        fields.collectFirst { case t: ReferenceConversionRatePercentDiff4841 => t },
        fields.collectFirst { case t: POSPostalCode4842 => t },
        fields.collectFirst { case t: AdditionalFraudData4843 => t },
        fields.collectFirst { case t: ExchangeRateProvider4844 => t },
        fields.collectFirst { case t: RateTableId4845 => t },
        fields.collectFirst { case t: PersistentFxEligibleIndicator4846 => t },
        fields.collectFirst { case t: PersistentFxAppliedIndicator4847 => t },
        fields.collectFirst { case t: FraudScoringData4848 => t },
        fields.collectFirst { case t: SecurityServicesAdditionalData4849 => t },
        fields.collectFirst { case t: MerchantAdviceCode4850 => t },
        fields.collectFirst { case t: UniqueTransactionIdentifier4852 => t },
        fields.collectFirst { case t: TransactionLinkIdentifier4853 => t },
        fields.collectFirst { case t: MatchKey4854 => t },
        fields.collectFirst { case t: ECommerceAuthentificationType4855 => t }
      ),
    pd =>
      List.concat(
        pd.operationType01,
        pd.acceptanceCountryCode02,
        pd.transactionEnvType03,
        pd.trackOrChip04,
        pd.originTransactionReturnCode05,
        pd.terminalPartialAuthorSupport06,
        pd.originTransactionNetwork07,
        pd.cashbackAmount08,
        pd.accountingPeriodNb09,
        pd.paymentOption10,
        pd.transactionStatus11,
        pd.preAuthorizationValidityPeriod12,
        pd.deviceType13,
        pd.walletType14,
        pd.transactionAnalysis15,
        pd.offlineAccumulator1_16,
        pd.offlineAccumulator2_17,
        pd.resetAccumulator1_18,
        pd.resetAccumulator2_19,
        pd.offlineContactLimitAmount20,
        pd.offlineContactlessLimitAmount21,
        pd.transactionCategoryCode22,
        pd.schemeNetworkAuthentication23,
        pd.eCommerceAuthentificationFlag24,
        pd.protocolVersion25,
        pd.DS_ACS_TransactionId26,
        pd.amountTransactionFee27,
        pd.atmServiceFee28,
        pd.atmDisloyaltyFee29,
        pd.creditCardFee30,
        pd.localMerchantCategoryCode31,
        pd.merchantId32,
        pd.financialNetworkCode33,
        pd.banknetReferenceNumber34,
        pd.recurringPaymentIndicator35,
        pd.finalAuthorizationIndicator36,
        pd.transitTransactionTypeIdentifier37,
        pd.transportationModeIndicator38,
        pd.referenceConversionRate39,
        pd.referenceConversionRateSide40,
        pd.referenceConversionRatePercentDiff41,
        pd.POSPostalCode42,
        pd.additionalFraudData43,
        pd.exchangeRateProvider44,
        pd.rateTableId45,
        pd.persistentFxEligibleIndicator46,
        pd.persistentFxAppliedIndicator47,
        pd.fraudScoringData48,
        pd.securityServicesAdditionalData49,
        pd.merchantAdviceCode50,
        pd.uniqueTransactionIdentifier52,
        pd.transactionLinkIdentifier53,
        pd.matchKey54,
        pd.eCommerceAuthentificationType55
      )
  ))

}
