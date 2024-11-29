package codec.types.field55

import codec.FieldCodecs.{ LLVAR, LLVAR_AN, LLVAR_N, N }
import com.neovisionaries.i18n.CountryCode
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }

case class ChipData55(
    terminalVerificationResult01: Option[TerminalVerificationResult5501],
    terminalCountryCode02: Option[TerminalCountryCode5502]
)

object ChipData55 {

  val subFieldCodec: Codec[ChipData55XX] = discriminated[ChipData55XX]
    .by(N(4))
    .typecase(TerminalVerificationResult5501.TAG, "TerminalVerificationResult01" | TerminalVerificationResult5501.codec)
    .typecase(TerminalCountryCode5502.TAG, "TerminalCountryCode02" | TerminalCountryCode5502.codec)

  val codec: Codec[ChipData55] = LLVAR(
    list(subFieldCodec).xmap(
      fields =>
        ChipData55(
          fields.collectFirst { case t: TerminalVerificationResult5501 => t },
          fields.collectFirst { case t: TerminalCountryCode5502 => t }
        ),
      cd =>
        List.concat(
          cd.terminalVerificationResult01,
          cd.terminalCountryCode02
        )
    )
  )

}

trait ChipData55XX

case class TerminalVerificationResult5501(result: String) extends ChipData55XX

object TerminalVerificationResult5501 {
  val TAG = "0095"

  val codec: Codec[TerminalVerificationResult5501] = LLVAR_AN.as[TerminalVerificationResult5501]
}

case class TerminalCountryCode5502(countryCode: CountryCode) extends ChipData55XX

object TerminalCountryCode5502 {
  val TAG = "9f1a"

  val codec: Codec[TerminalCountryCode5502] = LLVAR_N
    .xmap[CountryCode](
      s => CountryCode.getByCode(s.toInt),
      cc => String.format("%04d", cc.getNumeric)
    )
    .as[TerminalCountryCode5502]

}
