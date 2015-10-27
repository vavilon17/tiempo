import com.data.CachedDataStore
import com.rest.wwo_import.UrlProvider

beans = {
    importUrlProvider(UrlProvider) {
        baseUrl = application.config.wwo.baseUrl
        key = application.config.wwo.apiKey
        numOfDays = application.config.wwo.numOfDays
    }
}
