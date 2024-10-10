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
    terminalPartialAuthorSupport06: Option[TerminalPartialAuthorSupport4806]
)

object PrivateData48 {
  private val subFieldCodec = {
    discriminated[PrivateData48XX]
      .by(N(2))
      .typecase("01", "OperationType01" | OperationType4801.codec)
      .typecase(
        "02",
        "AcceptanceCountryCode02" | AcceptanceCountryCode4802.codec
      )
      .typecase("03", "TransactionEnvType03" | TransactionEnvType4803.codec)
      .typecase("04", "TrackOrChip04" | TrackOrChip4804.codec)
      .typecase(
        "05",
        "OriginTransactionReturnCode05" | OriginTransactionReturnCode4805.codec
      )
      .typecase(
        "06",
        "TerminalPartialAuthorSupport06" | TerminalPartialAuthorSupport4806.codec
      )
  }

  val codec: Codec[PrivateData48] = list(subFieldCodec).xmap(
    fields => {
      val ot01 = fields.collectFirst({ case t: OperationType4801 => t })
      val acc02 = fields.collectFirst({ case t: AcceptanceCountryCode4802 =>
        t
      })
      val tet03 = fields.collectFirst({ case t: TransactionEnvType4803 =>
        t
      })
      val toc04 = fields.collectFirst({ case t: TrackOrChip4804 => t })
      val or05 = fields.collectFirst({
        case t: OriginTransactionReturnCode4805 => t
      })
      val pas06 = fields.collectFirst({
        case t: TerminalPartialAuthorSupport4806 => t
      })
      PrivateData48(ot01, acc02, tet03, toc04, or05, pas06)
    },
    pd =>
      List.concat(
        pd.operationType01,
        pd.acceptanceCountryCode02,
        pd.transactionEnvType03,
        pd.trackOrChip04,
        pd.originTransactionReturnCode05,
        pd.terminalPartialAuthorSupport06
      )
  )
}
