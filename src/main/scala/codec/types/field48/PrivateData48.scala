package codec.types.field48

import codec.FieldCodecs.N
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
    transactionCategoryCode22: Option[TransactionCategoryCode4822]
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

  val codec: Codec[PrivateData48] = list(subFieldCodec).xmap(
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
        fields.collectFirst { case t: TransactionCategoryCode4822 => t }
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
        pd.transactionCategoryCode22
      )
  )

}
