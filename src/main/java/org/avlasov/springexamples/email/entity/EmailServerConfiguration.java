package org.avlasov.springexamples.email.entity;

/**
 * Created By artemvlasov on 04/09/2018
 **/
public class EmailServerConfiguration {

    private String protocol;
    private String host;
    private int port;
    private String userName;
    private String password;
    private boolean fallback;
    private String folderName;
    private int pollingTimeout;

    private EmailServerConfiguration(String protocol, String host, int port, String userName, String password, boolean fallback, String folderName, int pollingTimeout) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.fallback = fallback;
        this.folderName = folderName;
        this.pollingTimeout = pollingTimeout;
    }

    public static EmailServerConfigurationBuilder getBuilder() {
        return new EmailServerConfigurationBuilder();
    }

    public static class EmailServerConfigurationBuilder {

        private String protocol;
        private String host;
        private int port;
        private String userName;
        private String password;
        private boolean fallback;
        private String folderName;
        private int pollingTimeout;

        private EmailServerConfigurationBuilder() {}

        public EmailServerConfigurationBuilder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public EmailServerConfigurationBuilder setHost(String host) {
            this.host = host;
            return this;
        }

        public EmailServerConfigurationBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public EmailServerConfigurationBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public EmailServerConfigurationBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public EmailServerConfigurationBuilder setFallback(boolean fallback) {
            this.fallback = fallback;
            return this;
        }

        public EmailServerConfigurationBuilder setFolderName(String folderName) {
            this.folderName = folderName;
            return this;
        }

        public EmailServerConfigurationBuilder setPollingTimeout(int pollingTimeout) {
            this.pollingTimeout = pollingTimeout;
            return this;
        }

        public EmailServerConfiguration createEmailServerConfiguration() {
            return new EmailServerConfiguration(protocol, host, port, userName, password, fallback, folderName, pollingTimeout);
        }
    }

}
