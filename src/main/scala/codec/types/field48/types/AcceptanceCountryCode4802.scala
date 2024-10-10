package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import com.neovisionaries.i18n.CountryCode
import scodec.Codec

case class AcceptanceCountryCode4802(code: CountryCode) extends PrivateData48XX

object AcceptanceCountryCode4802 {

  val codec: Codec[AcceptanceCountryCode4802] =
    LLVAR_N.xmap(
      s => AcceptanceCountryCode4802(CountryCode.getByCode(Integer.parseInt(s))),
      cc => String.format("%04d", cc.code.getNumeric)
    )
}
