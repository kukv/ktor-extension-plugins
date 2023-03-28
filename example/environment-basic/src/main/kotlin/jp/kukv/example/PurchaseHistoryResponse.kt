package jp.kukv.example

import jp.kukv.environment.EnvironmentComponent
import jp.kukv.environment.inject
import jp.kukv.environment.injectList
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class PurchaseHistoryResponse(
    @SerialName("product_name")
    private val productName: String,

    @SerialName("price")
    private val price: Int,

    @SerialName("quantity")
    private val quantity: Int,

    @Serializable(with = BigDecimalSerializer::class)
    @SerialName("tax")
    private val tax: BigDecimal,

    @SerialName("date_of_purchase")
    private val dateOfPurchase: LocalDateTime,

    @SerialName("scheduled_settlement_date")
    private val scheduledSettlementDate: LocalDate,

    @SerialName("tags")
    private val tags: List<String>
) {

    companion object : EnvironmentComponent {

        fun factory(): PurchaseHistoryResponse {
            val productName by inject<String>("purchaseHistory.productName")
            val price by inject<Int>("purchaseHistory.price")
            val quantity by inject<Int>("purchaseHistory.quantity")
            val tax by inject<BigDecimal>("purchaseHistory.tax")
            val dateOfPurchase by inject<LocalDateTime>("purchaseHistory.dateOfPurchase")
            val scheduledSettlementDate by inject<LocalDate>("purchaseHistory.scheduledSettlementDate")
            val tags by injectList<String>("purchaseHistory.tags")

            return PurchaseHistoryResponse(
                productName,
                price,
                quantity,
                tax,
                dateOfPurchase,
                scheduledSettlementDate,
                tags
            )
        }
    }
}
