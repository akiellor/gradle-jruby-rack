require 'sinatra/base'

module Example
  class App < Sinatra::Base
    get "/ping" do
      body "PONG"
    end
  end
end