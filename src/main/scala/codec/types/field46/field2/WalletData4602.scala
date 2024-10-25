package codec.types

import codec.FieldCodecs.{ LLVAR, N }
import codec.types.field46.field2.types.*
import scodec.Codec
import scodec.codecs.{ discriminated, list }

trait WalletData4602XX

case class WalletData4602(
    providerRiskAssessment01: Option[ProviderRiskAssessment460201],
    providerRiskAssessmentVersion02: Option[
      ProviderRiskAssessmentVersion460202
    ],
    providerAccountScore03: Option[ProviderAccountScore460203],
    providerReasonCode05: Option[ProviderReasonCode460205],
    accountId06: Option[AccountId460206],
    xPayId07: Option[XPayId460207],
    appPaymentInstanceId08: Option[AppPaymentInstanceId460208]
) extends WalletInfos46XX

object WalletData4602 {

  private val subFieldsCodec: Codec[WalletData4602XX] =
    discriminated[WalletData4602XX]
      .by(N(2))
      .typecase("01", ProviderRiskAssessment460201.codec)
      .typecase("02", ProviderRiskAssessmentVersion460202.codec)
      .typecase("03", ProviderAccountScore460203.codec)
      .typecase("05", ProviderReasonCode460205.codec)
      .typecase("06", AccountId460206.codec)
      .typecase("07", XPayId460207.codec)
      .typecase("08", AppPaymentInstanceId460208.codec)

  val codec: Codec[WalletData4602] = LLVAR(list(subFieldsCodec))
    .xmap(
      fields =>
        WalletData4602(
          fields.collectFirst { case t: ProviderRiskAssessment460201 => t },
          fields.collectFirst { case t: ProviderRiskAssessmentVersion460202 => t },
          fields.collectFirst { case t: ProviderAccountScore460203 => t },
          fields.collectFirst { case t: ProviderReasonCode460205 => t },
          fields.collectFirst { case t: AccountId460206 => t },
          fields.collectFirst { case t: XPayId460207 => t },
          fields.collectFirst { case t: AppPaymentInstanceId460208 => t }
        ),
      wd =>
        List.concat(
          wd.providerRiskAssessment01,
          wd.providerRiskAssessmentVersion02,
          wd.providerAccountScore03,
          wd.providerReasonCode05,
          wd.accountId06,
          wd.xPayId07,
          wd.appPaymentInstanceId08
        )
    )

}
