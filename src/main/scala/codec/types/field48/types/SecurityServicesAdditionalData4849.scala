package codec.types.field48.types

import codec.FieldCodecs.{LLVAR, LLVAR_AN, N}
import codec.types.field48.PrivateData48XX
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class SecurityServicesAdditionalData4849(
    securityServicesIndicator01: Option[SecurityServicesIndicator484801],
    securityServicesData02: Option[SecurityServicesData484802]
) extends PrivateData48XX

object SecurityServicesAdditionalData4849 {

  private val subFieldCodec =
    discriminated[SecurityServicesAdditionalData4849XX]
      .by(N(2))
      .typecase("01", "SecurityServicesIndicator01" | SecurityServicesIndicator484801.codec)
      .typecase("02", "SecurityServicesData02" | SecurityServicesData484802.codec)

  val codec: Codec[SecurityServicesAdditionalData4849] = LLVAR(
    list(subFieldCodec).xmap(
      fields =>
        SecurityServicesAdditionalData4849(
          fields.collectFirst { case t: SecurityServicesIndicator484801 => t },
          fields.collectFirst { case t: SecurityServicesData484802 => t }
        ),
      ssa =>
        List.concat(
          ssa.securityServicesIndicator01,
          ssa.securityServicesData02
        )
    )
  )

}

trait SecurityServicesAdditionalData4849XX

case class SecurityServicesIndicator484801(id: String) extends SecurityServicesAdditionalData4849XX

object SecurityServicesIndicator484801 {
  val codec: Codec[SecurityServicesIndicator484801] = LLVAR_AN.as[SecurityServicesIndicator484801]
}

case class SecurityServicesData484802(data: String) extends SecurityServicesAdditionalData4849XX

object SecurityServicesData484802 {

  val codec: Codec[SecurityServicesData484802] = LLVAR_AN.as[SecurityServicesData484802]
}
